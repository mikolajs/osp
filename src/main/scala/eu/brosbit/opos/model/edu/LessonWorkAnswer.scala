package eu.brosbit.opos.model.edu


import _root_.net.liftweb.mongodb._
import org.bson.types.ObjectId

case class AnswerWorkItem (var q:String, var a: String, var p: Int) {
  import net.liftweb.json.Serialization.write
  import net.liftweb.json.DefaultFormats
  //def json = """ {"q": "%s", "a": "%s" , "p" : "%d" } """.format(q, a.replace("\n", "\\n"), p)
  implicit val formats = DefaultFormats
  def json = write(this)
}


//TODO: completely change
object LessonWorkAnswer extends MongoDocumentMeta[LessonWorkAnswer] {
  override def collectionName = "examanswers"

  override def formats = super.formats + new ObjectIdSerializer + new DateSerializer

  def create = new LessonWorkAnswer.(ObjectId.get, ObjectId.get, "", 0, 0L, "", Nil, "", "")
}

case class LessonWorkAnswer(var _id: ObjectId, var exam:ObjectId, var code:String, var max:Int,
                      var authorId: Long,  var authorName : String, var answers: List[AnswerItem],
                      var attach: String, var info: String) extends MongoDocument[LessonWorkAnswer] {
  def meta = LessonWorkAnswer

}
