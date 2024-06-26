/*
 * <무게의 제한이 있는 배낭에 물건들을 넣어 가장 높은 가치를 찾는 문제>
 * 
 * dp문제인데, 왜 재귀로는 시간초과가 나는지 아직도 이해를 못했다.
 * 단순히 함수호출 문제가 아니라, 중복되는 계산이 있다는 얘기 같은데..모르겠음 아직
 * 그냥 수치를 계산 했을 때 재귀는 N^2이고, DP는 N*K 보다도 덜 나오긴 한다.
 * 수치로는 알겠는데 논리적으로 아직 이해하지 못햇다.
 * 
 * 그래도 DP 기본원리에 대해 맛볼 수 있는 간단한 문제였다. 
 * 이 문제에서는 dp배열의 기준을 배낭의 무게로 삼았다.
 * 각각의 무게에서 담을 수 있는 가장 높은 가치를 갱신해감으로써,
 * 배낭에 자리가 남았을 때 그 무게만큼 딱맞는 최적해를 다시 더해서 지금의 최적해와 비교할 수 있다.
 * 
 * 이렇게 생각하니 왜 재귀는 중복 계산이고 DP는 중복계산이 없었는지 이해가 되려고 하넹;
 * 미리 각 무게에 대한 최적해를 구해놓으니 정확히 해당하는 무게에서 최적해를 가져올 수 있다.
 * 재귀에서는 경우의 수를 모두 확인하기 때문에 최적의 무게에 딱 맞지 않더라도 다 확인해봤겠지..
 * 
 * 왜 사용하는지 알것도 같다. 근데 다른 문제도 더 풀어봐야겠다.
 * 
 * [DP 개념 설명 참고 레퍼런스]
 * - https://sskl660.tistory.com/88
 * - https://loosie.tistory.com/150
 */
package boj_12865_평범한배낭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();			// 물건의 수
		int K = sc.nextInt();			// 배낭 무게 제한
		
		int[][] items = new int[N][2];	// N개 물건의 각 무게와 가치
		int[] dp = new int[K+1];		// 최적해 배열(패딩)
		
		// 물건 정보 입력
		for (int i = 0; i < N; i++) {
			items[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		// 물건을 모두 확인
		for (int i = 0; i < N; i++) {
			
			// dp배열 1차원이라서 역방향으로 갱신
			// 각 배낭 무게별 최적해를 갱신
			for (int j = K; j >= items[i][0]; j--) {
				
				// 해당 무게에서 현재 최적해와 지금 넣을 수 있는 물건을 비교하여 갱신
				// 이때, 해당 무게에서 넣으려는 물건에 무게를 빼서 여유자리를 확인해야 함
				// [해당 무게 - 넣을 물건무게] 인덱스에 있는 최적해를 더해준다.
				dp[j] = Math.max(dp[j], items[i][1] + dp[j-items[i][0]]);
			}
		}

		System.out.println(dp[K]);
		sc.close();
	}
}
