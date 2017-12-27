import java.util.*;


public class SearchAlgorithm  {

	public NodeList DepthFirstSearch(Node start, Node end) {


		NodePriorityQueue fakestack = new NodePriorityQueue();
		NodeList nodepath = new NodeList();
		NodeSet visitedset = new NodeSet();

		fakestack.add(start, 0);
		visitedset.add(start);


		int priority = 0; //helper int for priority queue, add(Node node, int priority)

		while (start != end) {
			start = fakestack.poll();
			nodepath.add(start);
			for (Iterator<Edge> itr = start.getChildren(); itr.hasNext();) {
				Node nextchild = itr.next().getChild();

				if (!visitedset.contains(nextchild)) {

					fakestack.add(nextchild, priority);
				}
				priority-=1;
			}
		}
		return nodepath;
	}


//	public NodeList DepthFirstSearch(Node start, Node end) {
//		NodeSet visitedset = new NodeSet();
//		//ArrayList Children = new ArrayList<>();
//		NodeList stack = new NodeList();
//		NodeList nodepath = new NodeList();
//		//push nodes on
//		stack.add(start);
//		visitedset.add(start);
//
//		//create condition to add nodes
//		while (!stack.isEmpty()) {
//			//main traversal
//			Node current = stack.remove(0);
//			nodepath.add(current);
//			if(current.equals(end)){
//				//when it reaches the end node
//				break;
//			}
//			//if (!visitedset.contains(nextNode)) stack.add(0, nextNode);
//
//			else {
//				NodePriorityQueue myqueue = new NodePriorityQueue();
//				for (Iterator<Edge> EdgeIterator = current.getChildren(); EdgeIterator.hasNext();) {
//					Edge nextEdge = EdgeIterator.next();
//					Node nextNode = nextEdge.getChild();
//					myqueue.add(nextNode, 0);
//					//add into a specific order in a priority queue
//					//original for 31  myqueue.add(nextNode, nextEdge.getWeight());
//				}
//				while (!myqueue.isEmpty()) {
//					//push them out into a stack in correct order
//					Node tempnode = myqueue.poll();
//					//will add lowest priority node which will print in reverse order
//					if (!visitedset.contains(tempnode)) stack.add(0,tempnode);
//					if(tempnode.equals(end)) {
//						nodepath.add(tempnode);
//						return nodepath;}
//				}
//			}
//		}
//		return nodepath;
//	}

	public NodeList BreadthFirstSearch(Node start, Node end) {
		NodePriorityQueue fqueue = new NodePriorityQueue();
		NodeList nodepath = new NodeList();
		NodeSet visitedset = new NodeSet();

		fqueue.add(start, 0);
		visitedset.add(start);


		int priority = 0;

		while (start != end) {
			start = fqueue.poll();
			nodepath.add(start);
			visitedset.add(start);

			for (Iterator<Edge> itr = start.getChildren(); itr.hasNext();) {
				Node nextchild = itr.next().getChild();
				if (!visitedset.contains(nextchild)) {
					fqueue.add(nextchild, priority);
				}

			}
			priority+=1;
		}
		return nodepath;
	}

	public NodeList UniformCostSearch(Node start, Node end) {
		NodeList nodepath = new NodeList();
		NodeSet visitedset = new NodeSet();
		NodePriorityQueue queue = new NodePriorityQueue();

		queue.add(start, 0);
		visitedset.add(start);


		int priority = 0;

		while (start != end) {
			start = queue.poll();
			nodepath.add(start);
			visitedset.add(start);

			for (Iterator<Edge> itr = start.getChildren(); itr.hasNext();) {
				Edge next = itr.next();
				if (!visitedset.contains(next.getChild())) {
					queue.add(next.getChild(), next.getWeight());
				}

			}
			priority+=1;
		}
		return nodepath;
	}

	public NodeList UniformCostSearchWithPath(Node start, Node end) {
		// 0 point challenge question
		return new NodeList();
	}

}




