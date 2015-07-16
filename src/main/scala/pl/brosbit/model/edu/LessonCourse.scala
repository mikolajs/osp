package pl.brosbit.model.edu

import _root_.net.liftweb.mongodb._
import java.util.Date
import org.bson.types.ObjectId

case class LessonContent(what: String, id: String, title: String, descript: String) {
  def forJSONStr = "{\"what\":\"" + what + "\",\"id\":\"" + id + "\",\"title\":\"" +
    title + "\",\"descript\":\"" + descript + "\"}"
}

// what: headword - h,  quest - q


case class LessonItem(what: String, id: String, title: String, descript: String)

object LessonCourse extends MongoDocumentMeta[LessonCourse] {
  override def collectionName = "lessons"

  override def formats = super.formats + new ObjectIdSerializer + new DateSerializer

  def create = new LessonCourse(ObjectId.get, 99, 0L, "", "", "",
    new ObjectId("000000000000000000000000"), Nil)
}

case class LessonCourse(var _id: ObjectId, var nr: Int, var authorId: Long,
                        var chapter: String, var title: String,
                        var descript: String, var courseId: ObjectId, var contents: List[LessonContent])
  extends MongoDocument[LessonCourse] {
  def meta = LessonCourse
}
