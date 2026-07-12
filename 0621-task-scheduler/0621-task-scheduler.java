class Task{
    int freq;
    int time; 
    public Task(int f,int t){
       this.freq=f;
       this.time=t;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
      int time=0;
      PriorityQueue<Task> maxHeap=new PriorityQueue<>((a,b)->b.freq-a.freq);
      Queue<Task> queue = new LinkedList<>();
      int[] counts = new int[26];
      for(char t : tasks){
        counts[t-'A']=counts[t-'A']+1;
      }
      for(int c :counts){
        if(c>0){
           maxHeap.add(new Task(c,1)); 
        }
      }
      while(!maxHeap.isEmpty()|| !queue.isEmpty()){
        time=time+1;
        while(!queue.isEmpty()&& queue.peek().time==time){
            maxHeap.add(queue.poll());
        }
        if(!maxHeap.isEmpty()){
            Task taskToExecute = maxHeap.poll();
            taskToExecute.freq = taskToExecute.freq-1;
            taskToExecute.time= time+(n+1);
            if(taskToExecute.freq>0){
               queue.add(new Task(taskToExecute.freq,taskToExecute.time)); 
            }

        }
      }
      return time;  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna