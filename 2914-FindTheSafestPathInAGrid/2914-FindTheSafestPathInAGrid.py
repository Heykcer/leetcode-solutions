# Last updated: 8/13/2026, 10:10:32 PM
class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        import numpy as np
        import heapq
        n=len(grid)
        
        dist_dict={}
        bfs_que=[]
        bfs_visited=set()
        # Finding Thieves
        for i in range(n):
            for j in range(n):
                if grid[i][j]==1:
                    bfs_que.append((i,j))

        # BFS to set minimum distance to theives 
        curr_depth=0
        while bfs_que:
            next_bfs_que=[]

            for x,y in bfs_que:
                if (x,y) in dist_dict:
                    continue
                else:
                    dist_dict[(x,y)]=curr_depth
                    for x_new,y_new in [(x+1,y),(x-1,y),(x,y+1),(x,y-1)]:
                        if x_new >=0 and x_new<n and y_new>=0 and y_new<n:
                            next_bfs_que.append((x_new,y_new))
            bfs_que=next_bfs_que
            curr_depth+=1

 
        # Dijkstra to find the maximum safeness factor path
        p_que=[(-dist_dict[(0,0)],0,0)]
        heapq.heapify(p_que)
        visited=set()
        
        while p_que:
            dist,x,y=heapq.heappop(p_que)
            dist=dist*(-1)

            if (x,y) in visited:
                continue
            
            visited.add((x,y))
            if x==n-1 and y==n-1:
                return dist
            
            for x_new,y_new in [(x+1,y),(x-1,y),(x,y+1),(x,y-1)]:
                if x_new >=0 and x_new<n and y_new>=0 and y_new<n:
                    heapq.heappush(p_que,(-min(dist,dist_dict[(x_new,y_new)]),x_new,y_new))