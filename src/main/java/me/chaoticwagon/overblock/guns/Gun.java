package me.chaoticwagon.overblock.guns;

public abstract class Gun{

    //The Item name for the gun
    private String name;
    public abstract String getName();

    //So that we can organize and treat different guns differently
    private GunType type;
    public abstract GunType getGunType();

    //Damage in hp for now, might make a custom health system later
    private double damage;
    public abstract double getDamage();

    //Weight in pounds, each player can only hold 100 pounds unless changed by a class
    private double weight;
    public abstract double getWeight();

    //This is the distance in blocks that the gun can shoot
    private double range;
    public abstract double getRange();

    //This is how fast the gun fires
    private double fireRate;
    public abstract double getFireRate();

    //This is the amount of ammo in each magazine
    private int ammo;
    public abstract int getAmmo();

    public FiringMode firingMode;
    public abstract FiringMode getFiringMode();

    public double reloadTime;
    public abstract double getReloadTime();






}
