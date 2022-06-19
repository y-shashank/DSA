package com.company.dynamicprogramming;

//Using the following mapping, a message comprising characters from A to Z can be encoded into numbers:
//  'A' = "1" 'B" = "2"... 'Z" = "26"
//  To decode an encoded message, all of the digits must be gathered and then mapped back into letters using the opposite of the aforementioned mapping (there may be multiple ways).
//  For example, "11106" can be translated as follows:
//  "KJF" with the grouping (11-10-6)
//  "AAJF" with the grouping (1-1-10-6)
//  It should be noted that the grouping (1 11 06) is illegal since "06" cannot be mapped into 'F' because "6" differs from "06".
//  Return the number of ways to decode a string s that solely contains digits.
//
//int numOfWaysToDecode(string s) {
//    int n = s.length();
//    vector<int> dp(n+1,0);
//
//    dp[0]=1;
//    if(s[0]!='0')
//        dp[1]=1;
//
//    for(int i=2;i<=n;i++){
//        int op1 = s[i-1]-'0';
//        int op2 = (s[i-2]-'0')*10 + (s[i-1]-'0');
//
//        if(op1>=1)
//            dp[i] += dp[i-1];
//        if(op2>=10 && op2<=26)
//            dp[i] += dp[i-2];
//    }
//
//    return dp[n];
//}
public class GivenAlphabetMappingDecodeNumber {
    public int process(String s){
        int dp[] = new int[s.length()];
        // there is only 1 way to convert if there is only character
        dp[0] = 1;
        for(int i = 1;i < s.length(); i++){
            if(s.charAt(i) == '0'){
                // if there is zero then it cannot be changed directly it has to be combined with s[i-1] and taken together
                dp[i] = dp[i-1];
            }else{
                // this is because this number can be individually converted into char
                dp[i] = dp[i-1] + 1;

                // if this prev number + current number are taken together as 1 number and if they are < 27 then they can be represented as valid char
                if((s.charAt(i-1) + s.charAt(i)) < 27){
                    dp[i] += 1;
                }
            }
        }
        return dp[s.length()-1];
    }
}
