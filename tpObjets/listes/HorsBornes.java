package listes;
public class HorsBornes extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HorsBornes() {
		this("Indice erroné");
	}

	public HorsBornes(String arg0) {
		super(arg0);
	}

	public HorsBornes(Throwable arg0) {
		super(arg0);
	}

	public HorsBornes(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
