package swingPackage;

public class Film {
	private String title;		//same cell A
	private String releaseDate;	//same cell A
	private String certificate;
	private int duration;
	private String genre;
	private float rate;
	private int metascore;
	private String description;
	private String director;	//same cell B
	private String[] stars;		//same cell B
	private int voteCount;		//same cell C
	private int grossRevenue;	//same cell C
	
	public Film(String title, String releaseDate, String certificate, int duration, String genre, float rate, int metascore, String description, String director, String[] stars, int voteCount, int grossRevenue) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.certificate = certificate;
		this.duration = duration;
		this.genre = genre;
		this.rate = rate;
		this.metascore = metascore;
		this.description = description;
		this.director = director;
		this.stars = stars;
		this.voteCount = voteCount;
		this.grossRevenue = grossRevenue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String[] getStars() {
		return stars;
	}
	
	public void setStars(String[] stars) {
		this.stars = stars;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public int getGrossRevenue() {
		return grossRevenue;
	}

	public void setGrossRevenue(int grossRevenue) {
		this.grossRevenue = grossRevenue;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
