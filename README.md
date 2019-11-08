[![](https://jitpack.io/v/foxtrot30/htmlspinner.svg)](https://jitpack.io/#foxtrot30/htmlspinner) ![GitHub tag (latest SemVer)](https://img.shields.io/github/v/tag/foxtrot30/htmlspinner) ![GitHub repo size](https://img.shields.io/github/repo-size/foxtrot30/htmlspinner) ![GitHub Release Date](https://img.shields.io/github/release-date/foxtrot30/htmlspinner)

# htmlspinner
**HtmlSpinner** is a library to simplify and shorten your coding when creating a spinner and make it easier for you to get the value of the spinner as in HTML and Javascript when getting the value of an option tag

## Goals
* provides a simple `val()` and `key()` method
* There is no need to create a new model to use this library, the default model is `HtmlSpinnerAdapter`.

## Download
Gradle (using jitpak.io repo) Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
   repositories {
     ...
     maven { url 'https://jitpack.io' }
   }
}
```

```gradle
dependencies {
  implementation 'com.github.foxtrot30:htmlspinner:1.0.0'
}
```

## Usage
```xml
<com.foxtrot30.htmlspinner.HtmlSpinner
   android:id="@+id/html_spinner"/>
```

```java
ArrayList<HtmlSpinnerModel> list = new ArrayList<>();
HtmlSpinnerModel model = new HtmlSpinnerModel();
model.setKey("");
model.setValue("Select an item.");
list.add(model);

for (int i = 0; i < 10; i++) {
  model = new HtmlSpinnerModel();
  model.setKey("Spinner key " + i);
  model.setValue("Spinner value " + i);

  list.add(model);
}

final HtmlSpinnerAdapter adapter = new HtmlSpinnerAdapter(Example.this, list);
HtmlSpinner htmlSpinner = findViewById(R.id.html_spinner);
htmlSpinner.setAdapter(adapter);
htmlSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText(Example.this, "Selected value : " + adapter.val(position) + "; Selected key : " + adapter.key(position), Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {
    Toast.makeText(Example.this, "nothing selected :)", Toast.LENGTH_SHORT).show();
  }
});
```

## License
HtmlSpinner is released under [GNU General Public License v3.0](https://github.com/foxtrot30/htmlspinner/blob/master/license.md)
