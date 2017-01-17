package projet;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Arme {
	private String 		nom;
	private int 		munition;
	private int			rechargement;
	private boolean		reloaded;
	private Timer 		timer;

	public Arme() {
		this.munition	= 0;
		this.rechargement = 200;
		this.reloaded = true;
	}
	
	public void setRechargement(int rechargement) {
		this.rechargement = rechargement;
	}
	
	public void recharger(int munition) {
		this.munition += munition;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public int getMunition(){
		return this.munition;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public boolean isReloaded() {
		return this.reloaded;
	}
	
	void setMunition(int munition){
		this.munition = munition;
	}
	
	public abstract Projectile fire(int x, int y, SensTirer sens);
	
	protected void reload() {
		this.reloaded = false;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				reloaded = true;
				timer.cancel();
			}
		};
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(timerTask, this.rechargement, 1);
	}
}
