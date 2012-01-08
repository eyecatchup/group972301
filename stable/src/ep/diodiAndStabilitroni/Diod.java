package ep.diodiAndStabilitroni;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="diod")
public class Diod implements Serializable{
	@Id
	@Column(name="iddiod")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="tok_pr_max")
	private Float tok_maks;
	
	@Column(name="tok_pr_i_max")
	private Float tok_i_maks;
	
	@Column(name="napr")
	private Float napr_maks;
	
	@Column(name="t_obr")
	private Float t_obr;
	
	@Column(name="type")
	private String name;

	
/*	static public Diod getDiod(Float tok, Float napr){
		if(napr < 100){
			
			return new Diod("йд226ю", 1.7, 10 , 100, 0.25);
		} else if (napr < 200){
			return new Diod("йд226а", 1.7, 10 , 200, 0.25);
		} else if (napr < 400) {
			return new Diod("йд226б",  1.7, 10 , 400, 0.25);
		} else if (napr < 600) {
			return new Diod("йд226ц", 1.7, 10 , 600, 0.25);
		} else if (napr < 800) {
			return new Diod("йд226д",  1.7, 10 , 800, 0.25);
		}
	
		return null;
	}*/

	public Float getTok_maks() {
		return tok_maks;
	}

	public void setTok_maks(Float tok_maks) {
		this.tok_maks = tok_maks;
	}

	public Float getTok_i_maks() {
		return tok_i_maks;
	}

	public void setTok_i_maks(Float tok_i_maks) {
		this.tok_i_maks = tok_i_maks;
	}

	public Float getNapr_maks() {
		return napr_maks;
	}

	public void setNapr_maks(Float napr_maks) {
		this.napr_maks = napr_maks;
	}

	public Float getT_obr() {
		return t_obr;
	}

	public void setT_obr(Float t_obr) {
		this.t_obr = t_obr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
