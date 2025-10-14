package Felipe.V3;

abstract class AbstractCharacter implements Character {
    protected WeaponBehavior weaponBehavior;

    public void setWeaponBehavior(WeaponBehavior w) {
        this.weaponBehavior = w;
    }

    public void fight() {
        if (weaponBehavior != null) {
            weaponBehavior.fight();
        } else {
            System.out.println("Keine Waffe ausgewählt!");
        }
    }
}