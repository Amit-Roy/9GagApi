#9gag API
##Learning Dropwizard making a crude 9gag Api

Documentation

107.170.184.51:9000 - Sample Api Url

endpoints

* / - Documentation : [Usage](http://107.170.184.51:9000/)

* /image - Get latest 10 images : [Usage](http://107.170.184.51:9000/image)

* /image/nextSetParam - Get the next 10 Images : [Usage](http://107.170.184.51:9000/image/a4LYVY6,aYwLev2,aw7V5vx)

> nextSetParam - identifier returned with each image query. Just send it from the previous result : 

* /image/category - Get latest 10 images from specified category : [Usage] (http://107.170.184.51:9000/image/wtf)

* /image/category/nextSetParam - Get the next 10 Images from specified category : [Usage](http://107.170.184.51:9000/image/wtf/aojNVxm,aVX302d,abbM2BB)

> nextSetParam - identifier returned with each image query. Just send it from the previous result : 

> Example of categories are : hot, fresh, wtf, comic

> if an invalid category is entered you will get a 408 request timed out error : [Usage](http://107.170.184.51:9000/image/wzcvzxcvzxctf/aojNVxm,aVX302d,abbM2BB)

* /comment/id - Get Comments for image ID : [Usage](http://107.170.184.51:9000/comment/a4LYVY6)