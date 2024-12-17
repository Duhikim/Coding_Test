package CodingTestStudy.Tiling3xN;

class Solution_ver2 {

	public int solution(int n) {
		/*******
		 ver.1 을 식으로 쓰면 다음과 같다.
		 F(n) = F(n-2)*3 + (F(n-4)+F(n-6)+...+F(2)+F(0)) * 2 ..............(1)
		 (1) 식의 우변의 두번째 항을 보면,
		 (F(n-4) + F(n-6) + ... + F(2) + F(0)) * 2 ........................(2)
		 이 부분에 F(n-4)를 더해주면 이것은
		 F(n-2) =  F(n-4)* 3 + (F(n-6) + ... + F(2) + F(0)) * 2 와 똑같아진다.
		 즉 식(1)의 우변은 F(n-2) - F(n-4)이며 이것을 바탕으로 식 (1)을 다시 쓰면
		 F(n) = F(n-2) * 4 - F(n-4)  .......................................(3)
		 로 훨씬 간단해진다.
		 하지만 mod를 사용하고 뺄셈이 나오는 만큼 음수가 되는 것을 항상 주의하여야 한다.
		 *******/

		if(n%2==1) return 0;
		int mod = 1_000_000_007;
		long[] dp = new long[n+1];

		dp[0] = 1;
		dp[2] = 3;
		for(int i=4; i<=n; i+=2){
			dp[i] = (4*(dp[i-2]) - dp[i-4] + mod)%mod;
		}


		return (int)(dp[n]);
	}
}