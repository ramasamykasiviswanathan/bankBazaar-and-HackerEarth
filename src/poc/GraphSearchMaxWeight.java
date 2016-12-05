package poc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class GraphSearchMaxWeight
{
	static volatile Integer weightedGraph[][], vertices;
	static Stack<Integer> visitedNodes = new Stack<>();
	
	public static void main(String[] args)
	{
		//populateWeightedGraphUserInput();
		populateWeightedGraph();
	}
	public Integer calculateMaxValue(int endVertex)
	{
		Integer currentPathCost = null, maxFromVertex = null , maxToVertex = null;
		for(int i=0 ; i<vertices ; ++i)
		{
			if(visitedNodes.contains(i)|| i==endVertex)
				continue;
			if(weightedGraph[visitedNodes.peek()][i]!=null)
			{
				visitedNodes.push(i);
				Integer calculateMaxValue = new GraphSearchMaxWeight().calculateMaxValue(endVertex), 
						currentWeight = weightedGraph[maxFromVertex=visitedNodes.pop()][maxToVertex=visitedNodes.peek()];
				if(calculateMaxValue != null && (currentPathCost == null || currentPathCost< (calculateMaxValue + currentWeight)))
				{
					currentPathCost = calculateMaxValue + currentWeight;
				}
			}
		}
		if(weightedGraph[visitedNodes.peek()][endVertex]!=null && (currentPathCost == null || currentPathCost < weightedGraph[visitedNodes.peek()][endVertex]))
		{
			currentPathCost = weightedGraph[maxFromVertex=visitedNodes.peek()][maxToVertex=endVertex];
		}
//		printStack();
//		System.out.printf("\nmaxFromVertex:%d\tmaxToVertex: %d",maxFromVertex,maxToVertex);
//		System.out.printf("\ncurrentpathcost:%d", currentPathCost);
		return currentPathCost;
	}
	
	public static void populateWeightedGraph()
	{
		weightedGraph = new Integer[10][10];
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			String[] stringArray = new String[]
			{ "4,1,5", "1,2,5", "1,3,5", "1,4,5", "2,1,5", "2,7,10", "2,8,5", "3,1,5", "3,5,10", "3,9,5", "4,6,5",
					"4,10,10", "5,3,10", "5,6,15", "5,8,15", "6,4,5", "6,5,15", "6,7,15", "7,2,10", "7,6,15", "7,9,15",
					"8,2,5", "8,5,15", "8,10,15", "9,3,5", "9,7,15", "9,10,15", "10,4,10", "10,8,15", "10,9,15" };
			for (String strtemp : stringArray)
			{
				String[] str = strtemp.split(",");
				int start = Integer.valueOf(str[0]) - 1, end = Integer.valueOf(str[1]) - 1,
						value = Integer.valueOf(str[2]);
				weightedGraph[start][end] = value;
				weightedGraph[end][start] = value;
			}
			System.out.print("Enter From Vertex:");
			visitedNodes.push(Integer.valueOf(br.readLine()) - 1);
			System.out.print("Enter To Vertex:");
			vertices = 10;
			System.out.println(new GraphSearchMaxWeight().calculateMaxValue(Integer.valueOf(br.readLine()) - 1));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printStack()
	{
		Iterator<Integer> iterator = visitedNodes.iterator();
		while(iterator.hasNext())
		{
			System.out.print("\t"+iterator.next());
		}
	}
	public static void populateWeightedGraphUserInput()
	{
		
		try(Scanner scanner = new Scanner(System.in))
		{
			vertices = scanner.nextInt();
			weightedGraph = new Integer[vertices][vertices];
			int edges = scanner.nextInt();
			while(edges-->0)
			{
				int vertex1,vertex2;
				System.out.printf("Enter first vertex of edge %d:",edges);
				vertex1 = scanner.nextInt();
				System.out.printf("Enter second vertex of edge %d:",edges);
				vertex2 = scanner.nextInt();
				System.out.printf("Enter edge weight %d:",edges);
				weightedGraph[vertex1-1][vertex2-1]= scanner.nextInt();
				weightedGraph[vertex2-1][vertex1-1]=weightedGraph[vertex1-1][vertex2-1];
			}
			System.out.print("Find MaxWeight:\nFromVertex:");
			visitedNodes.push(Integer.valueOf(scanner.nextInt()-1) - 1);
			System.out.print("ToVertex:");
			System.out.println(new GraphSearchMaxWeight().calculateMaxValue(scanner.nextInt()-1));
		}
	}
}
