package Lab3;

public class Translator {
    private StringBuilder result ;

    public String translate (Dictionary dictionary, String text) {
        result = new StringBuilder();
        int start = 0;
        int end,endMem;
        String ss;
        boolean stopTest;

        while (start < text.length()) {
            end = start + 1;
            endMem = start;
            if (Character.isLetter(text.charAt(start))) {
                stopTest = false;
                while ((end < text.length()) & (stopTest == false)) {
                    if (Character.isLetter(text.charAt(end))) {
                        end = end + 1;
                    }
                    else {
                        if (dictionary.isItContained(text.substring(start, end))) {
                            endMem = end;
                            end = end + 1;
                        }
                        else {
                            stopTest = true;
                        }
                    }
                }
                if (dictionary.isItContained(text.substring(start, end))) {
                    endMem = end;
                }
                start = this.putResult(dictionary,text,start,end,endMem);
            }
            else {
                start = this.putResult(dictionary,text,start,end,endMem);
            }
        }
        return (this.result.toString());
    }

    public int putResult (Dictionary dictionary,String text, int start, int end, int endMem) {
        if (start == endMem) {
            this.result.append(text.substring(start,end));
            start = end;
        }
        else {
            this.result.append(dictionary.getElem (text.substring(start,endMem)));
            start = endMem;
        }
        return start;
    }
}
