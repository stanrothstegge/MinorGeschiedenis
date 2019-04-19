package model;

class Answer {
    String meaning;

    public Answer(String meaning) {
        this.meaning = meaning;
    }

    boolean tryAnswer(String... parts){
        String whole = null;
        for(int i = 0; i<parts.length; i++){
            whole = whole + " " + parts[i];
        }
        if(whole == meaning){
            return true;
        }
    return false;
    }
}
