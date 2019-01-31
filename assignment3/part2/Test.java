public class Test{
	public static void main(String[] args){
		MoodyObject sadA = new SadObject();
		MoodyObject happyA = new HappyObject();
		PsychiatristObject psyA = new PsychiatristObject();

		psyA.examine(sadA);
		psyA.observe(sadA);

		System.out.println(sadA.getMood()); 
		System.out.println(happyA.getMood()); 
		sadA.expressFeelings();
		happyA.expressFeelings();

		sadA.queryMood();
		happyA.queryMood();

		System.out.println(sadA.toString());
		System.out.println(happyA.toString());


	}
}

abstract class MoodyObject{	
	protected abstract String getMood();

	protected abstract void expressFeelings();

	public void queryMood(){
		System.out.println("I feel so " + getMood() + " today!");
	}

}

class SadObject extends MoodyObject{
	protected String mood = "sad";
	protected String getMood(){
		return this.mood;
	}

	public void expressFeelings(){
		System.out.println("express sad! wah boo hoo weep sob weep");
	}

	public String toString(){
		return "Subject cries a lot";
	}

}

class HappyObject extends MoodyObject{
	protected String mood = "happy";
	protected String getMood(){
		return this.mood;
	}

	public void expressFeelings(){
		System.out.println("express happy! hehehe...hahaha...HAHAHAHA!");
	}

	public String toString(){
		return "Subject laughs a lot";
	}
}

class PsychiatristObject{
	public void examine(MoodyObject mo){
		System.out.println("How are you feeling today?");
	}

	public void observe(MoodyObject mo){
		System.out.println("Observation: " + mo.toString());
	}

}


