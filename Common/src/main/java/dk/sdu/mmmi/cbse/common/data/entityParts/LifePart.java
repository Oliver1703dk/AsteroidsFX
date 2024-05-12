package dk.sdu.mmmi.cbse.common.data.entityParts;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class LifePart implements EntityPart {

    private int life;
    private boolean isHit = false;
    private boolean expired = false;
    private int dmg;

    public LifePart(int life, int dmg) {
        this.life = life;
        this.dmg = dmg;
    }


    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }
    public boolean isExpired() {
        return expired;
    }

    @Override
    public void process(GameData gameData, Entity entity) {
//        if (isHit) {
//            life = life - 1;
//            isHit = false;
//        }
//        if (life <= 0) {
//            expired = true;
//        }
    }
}

