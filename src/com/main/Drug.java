 package com.main;


 /**
  *
  * This is the drug class, it describes all the attributes a Drug should have, and it is used by drugHeap to load the array
  */

public class Drug {
    String genericName, Smiles, drugBankID, url, drugGroup, score;

     /**
      * Constructor of Drug Class, it creates a drug taken a string array and splitting it into its separate components
      * @param names string array that's broken down
      */

    public Drug(String[] names) {
        genericName = names[0];
        Smiles = names[1];
        drugBankID = names[2];
        url = names[3];
        drugGroup = names[4];
        score = names[5];
    }

     /**
      * Next few methods are getters, they return the different attributes of the Drug
      * @return the string associated with that Drug attribute
      */
    public String getGenericName() {
        return genericName.trim();
    }

    public String getSmiles() {
        return Smiles.trim();
    }

    public String getDrugBankID() {
        return drugBankID.trim();
    }

    public String getUrl() {
        return url.trim();
    }

    public String getDrugGroup() {
        return drugGroup.trim();
    }

    public String getScore() {
        return score.trim();
    }

     /**
      * This method is used to print to the file, it takes all the parts of a Drug and puts them together into one string that can be used
      * @return a string with the full drug info
      */

    public String  displayDrug(){
        return (this.getGenericName() + " " + this.getSmiles() + " " + this.getDrugBankID() + " " + this.getUrl()+ " " + this.getDrugGroup() + " " + this.getScore() );
    }
}

