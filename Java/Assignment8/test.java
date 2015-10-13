public class test
{

	public static void main(String [] args)
	{
		int x = 0;
		int y = 0;
		
		for (int j = 0; j < 4; j++)
		{
			for (int k = 0; k < 4; k++)
			{
				if (k == 1)
				{
					x = j;
					y = k;
					System.out.println(x + " " + y);
					break;
				}
				y = k;
				System.out.println(x + " " + y);
			}
			x = j;
		}
		
		System.out.println(x + " " + y);
	}
}