public class Babies {

	private double[][] weight = {{2.5, 2.52, 2.7, 2.6, 2.5},
			{4.5, 4.6, 4.7, 5, 5.1},
			{2.5, 2.6, 2.5, 2.4, 2.2},
			{3.72, 3.8, 3.8, 3.7, 3.7},
	        {4.2, 4.22, 4.22, 4.3, 4.2},
			{1.5, 1.6, 1.82, 1.9, 2.2}};

	private double[][] height = {{0.51, 0.51, 0.52, 0.52, 0.53},
			{0.43, 0.43, 0.43, 0.43, 0.44},
			{0.47, 0.48, 0.49, 0.49, 0.49},
			{0.6, 0.6, 0.6, 0.6, 0.6},
			{0.53, 0.53, 0.54, 0.54, 0.54},
			{0.61, 0.61, 0.62, 0.63, 0.63}};

	public void check()
	{
	    for (int baby = 0; baby < weight.length; baby++){
	        if (weight[baby][0] > weight[baby][weight[baby].length-1])
	            System.out.println("baby number " + baby + 1);
	    }
	}
	public void max()
	{
	    double maxBmi = 0;
	    int maxBmiIdx = 0;
	    for (int baby = 0; baby < weight.length; baby++){
	        for (int check = 0; check < weight[baby].length; check++){
    	        if ((weight[baby][check] / (weight[baby][check] * weight[baby][check])) > maxBmi){
    	             maxBmi = (weight[baby][check] / (weight[baby][check] * weight[baby][check]));
    	             maxBmiIdx = baby;             
    	        }
	        }
	    }
	System.out.println(String.format("Max BMI is %f, in baby number", maxBmi) + maxBmiIdx);
	}
}
