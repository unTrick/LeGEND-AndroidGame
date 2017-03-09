package com.legend.game.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 * Created by Patrick Sky on 3/4/2017.
 */

public class Entity {

    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected int z;
    protected int xdest;
    protected int ydest;
    protected int zdest;
    protected int rowtile;
    protected int coltile;
    protected boolean moving;
    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;
    protected int moveSpeed;
    protected TiledMapTileLayer layer;
    protected int tileSize;

    public Entity(TiledMap map) {
        super();
        layer = (TiledMapTileLayer) map.getLayers().get(0);
        tileSize = map.getProperties().get("tilewidth", Integer.class);
    }

    public void setTilePostion(int i1, int i2, int i3) {
        x = i1 * tileSize;
        y = i2 * tileSize;
        z = i3 * tileSize;
        xdest = x;
        ydest = y;
        zdest = z;
    }

    public void setUp() {
        if (moving)
            return;
        up = true;
        moving = validateNextPostion();
    }

    public void setDown() {
        if (moving)
            return;
        down = true;
        moving = validateNextPostion();
    }

    public void setLeft() {
        if (moving)
            return;
        left = true;
        moving = validateNextPostion();
    }

    public void setRight() {
        if (moving)
            return;
        right = true;
        moving = validateNextPostion();
    }

    public boolean validateNextPostion() {
        rowtile = y / tileSize;
        coltile = x / tileSize;
        if (up) {
                if (layer.getCell(1, 1).getTile().getProperties()
                    .containsKey("block")) {
                return false;
            } else {
                ydest = y + tileSize;
            }
        }
        if (down) {
            if (layer.getCell(1, 1).getTile().getProperties()
                    .containsKey("block")) {
                return false;
            } else {
                ydest = y - tileSize;
            }
        }
        if (left) {
            if (layer.getCell(coltile - 1, rowtile).getTile().getProperties()
                    .containsKey("block")) {
                return false;
            } else {
                xdest = x - tileSize;
            }
        }
        if (right) {
            if (layer.getCell(coltile + 1, rowtile).getTile().getProperties()
                    .containsKey("block")) {
                return false;
            } else {
                xdest = x + tileSize;
            }
        }
        return true;
    }



//    public boolean validateNextPostion() {
//        rowtile = y / tileSize;
//        coltile = x / tileSize;
//        if (up) {
//            ydest = y + tileSize;
//        }
//        if (down) {
//            ydest = y - tileSize;
//        }
//        if (left) {
//            xdest = x - tileSize;
//        }
//        if (right) {
//            xdest = x + tileSize;
//        }
//        return true;
//    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void getNextPostion() {
        if (left && x > xdest) {
            x -= moveSpeed;
        } else {
            left = false;
        }
        if (left && x < xdest) {
            x = xdest;
        }
        if (right && x < xdest) {
            x += moveSpeed;
        } else {
            right = false;
        }
        if (right && x > xdest) {
            x = xdest;
        }
        if (up && y < ydest) {
            y += moveSpeed;
        } else {
            up = false;
        }
        if (up && y > ydest) {
            y = ydest;
        }
        if (down && y > ydest) {
            y -= moveSpeed;
        } else {
            down = false;
        }
        if (down && y < ydest) {
            y = ydest;
        }
    }

    public void updateEntity(float dt) {
        if (moving) {
            getNextPostion();
        }
        if (x == xdest && y == ydest) {
            up = down = left = right = moving = false;
            rowtile = y / tileSize;
            coltile = x / tileSize;
        }
    }
}

