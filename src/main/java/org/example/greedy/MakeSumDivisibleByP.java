package org.example.greedy;

import java.util.HashMap;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        //우리는 일단 total sum에 % p 한것에 remainder를 목표로 삼는다. 그래서 그 remainder가 prefix sum에서 길이가 가장 짧은 것이 답이 된다 왜냐 하면 우리는 최대한 긴 subarray를 가지고 싶어 하고 그것의 반대가 prefix sum에서 최소길이다.
        // [3,1,4]의 presum이 의미 하는 것은 마지막 항 2를 반드시 포함하고 314의 subarray들 중 하나를 제거 해서 최대 길이를 만든다는 것. [3,1,4,2] p =6 기준
        // 총 314의 합은 일단 8이고 그것의 나머지는 2이다. 그리고 토탈 어레이의 합이 10이고 그것의 나머지는 4다 고로, 우리는 2 -4를 통해서 리메인더가 4를 가지게 되고 그 말인 즉 프리섬 기준으로 그 전에 합들이 같은 리메인더를 가지고 있을 경우,
        // 그것만 챙기면 되기 때문에 리메인더 사는 우리가 [3, 1] 의 총 합이다 그럼으로 우리는 반드시 [3, 1] 그리고 [2]를 챙기면 된다 그럼 4를 빼기만 하면 된다는 뜻. 거꾸로 왔다 갔다 하는 것이 굉장히 까다롭다.
        //subarray is defined as a contiguous block of elements in the array. 이부분이 이상했지만 결국 각 항은 챙기되 인접한 항만 보면 되는 것.
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if(sum < p) {
            return -1;
        }
        int R = (int) (sum % p);
        if(R == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = (int) (sum % p);
            int key = r - R;
            if(key < 0) {
                key += p;
            }
            if(hm.containsKey(key)) {
                result = Math.min(result, i - hm.get(key));
            }
            hm.put(r, i);
        }
        if(result == nums.length || result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}
