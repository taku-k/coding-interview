package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {
  private class Process {
    int pid;
    List<Process> children;

    Process(int pid) {
      this.pid = pid;
      children = new ArrayList<>();
    }
  }

  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, Process> pidToNode = new HashMap<>();
    for (int i = 0; i < pid.size(); ++i) {
      pidToNode.putIfAbsent(pid.get(i), new Process(pid.get(i)));
      pidToNode.putIfAbsent(ppid.get(i), new Process(ppid.get(i)));
      pidToNode.get(ppid.get(i)).children.add(pidToNode.get(pid.get(i)));
    }
    List<Integer> result = new ArrayList<>();
    dfs(pidToNode.get(kill), result);
    return result;
  }

  private void dfs(Process p, List<Integer> result) {
    result.add(p.pid);
    for (Process child : p.children) {
      dfs(child, result);
    }
  }
}
