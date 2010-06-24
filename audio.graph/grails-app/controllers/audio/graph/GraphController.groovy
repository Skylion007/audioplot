package audio.graph

import audio.graph.data.Graph 
import java.io.File;

class GraphController{
	def graphService
	def index = {}
	def load = {	
		def downloadedfile = request.getFile('data');
		assert downloadedfile
		File ftmp = File.createTempFile("data", ".txt")
		downloadedfile.transferTo(ftmp)
		
		
		Graph graph = graphService.createGraph(ftmp)
		ftmp.delete()
		
		
		[description:graph.description]
		}
	
	def soundService
	def play = {
File f = soundService.playSound(graph)
assert f
return f
			}
	
}