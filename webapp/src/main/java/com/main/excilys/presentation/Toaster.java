package com.main.excilys.presentation;

public enum Toaster {
  INSTANCE;

  String sentence;
  String sentenceType;
  int duration;

  public static final String ERROR = "error";
  public static final String INFO = "info";
  public static final String SUCCESS = "success";

  /**
   * Simple Constructor.
   */
  Toaster() {

  }

  /**
   * Simple constructor to create a toast.
   *
   * @param sentence
   *          the char sequence to print on the toast
   * @param sentenceType
   *          the level of the toast (Error, Info, Success)
   * @param duration
   *          the time duration of the toast
   * @return An instance of Toaster
   */

  public Toaster getToast(String sentence, String sentenceType, int duration) {
    this.sentence = sentence;
    this.sentenceType = sentenceType;
    this.duration = duration;
    return this;
  }

  public String getSentence() {
    return sentence;
  }

  public String getSentenceType() {
    return sentenceType;
  }

  public int getDuration() {
    return duration;
  }

}
