package algos.dp;

import java.util.ArrayList;
import java.util.Stack;

//public class FindFilePathPattern {
//
//    public static ArrayList<String> getFindPattern(String patern){
//        ArrayList<String> matchedPatternlist = new ArrayList<>();
//        Stack<TranversData> tranversDataStack = new Stack<>();
//        ArrayList<String> currentfileNode =  listUtilty()
//
//              for(s: currentfileNode){
//                  if(tranversDataStack.equals())
//              }
//
//       return matchedPatternlist ;
//    }
//}
//
//class TranversData{
//
//    int lastTraverseMatchedPosition ;
//    String filepathSoFar;
//
//}
//
//
//
///*
//
//"/a/*/b" <--- Input
//        /a/x/b <--- Answer
//        /a/v
//        /a/f
//        /b/x/b
//
//        Implement the following function:
//
//        vector<string> listPattern(const string& pattern);
//        where "pattern" is a unix file system pathname with wildcats, e.g., "/a/*/b/*/c". Each component in the path is either a fully
//        qualified name e.g., "a", or a single wildcat "*". No need to worry about combinations of wildcats and non wildcats, e.g., "a*b".
//        Returns the list of file or directory names in the file system that match the given pattern.
//
//        ===========UTILITY================
//        Available library functions to use (in addition to the common string processing functions) :
//
//        vector<string> listPath(const string& path); /a --> [x, v, f] Like ls function
//
////answer > /a/x/b
//
//
//        /a/x/e/f/b
//
//        pattern > /a/x/b
//
//        a,
//
//
//        where "path" must be a fully qualified pathname. Returns a vector with only "path" in it if "path" is the name of a file. Returns a
//        vector with the names of child files or directories if "path" is the name of a directory. Returns an empty vector if no file or
//        directory with the name "path" exists in the file system.
//
//        bool exists(const string& path);
//        Returns true iff a file or directory with the name "path" exists in the file system.
//
//        */



