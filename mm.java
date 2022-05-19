package cop;

/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	

	import java.util.LinkedList;
	import java.util.ListIterator;
	import java.util.Scanner;


	public class songg {
 /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        Scanner input=new Scanner(System.in);
	        System.out.println("---------------------------Welcome All-------------------\n------------------- Create Your Own Playlist---------------");
	        System.out.println("Please Enter your Playlist Name");
	        String playlistname=input.nextLine();
	        LinkedList<songg>songs=new LinkedList();//Song is a class which has three fields song name,artist name and duration of the song
	        boolean first=true;
	        while(first){
	            System.out.println("\nEnter 1) To Add Songs To Playlist:  "+playlistname+"\n"+
	                                "Enter 2)To remove Songs From Playlist: "+playlistname+"\n"+
	                                 "Enter 3) To show the songs in Playlist: "+playlistname+"\n"+
	                                 "Enter 4) To Play The Playlist: "+playlistname+"\n"+
	                                 "Enter 5) To Exit");
	            int choice1=input.nextInt();
	            switch(choice1){
	                case 1:
	                       System.out.println("Enter The name of the Song");
	                       input.nextLine();//Just to eliminate the enter otherwise it will be stored as a input
	                       String songname=input.nextLine();
	                       System.out.println("Enter The Name of the artist");
	                       String artist=input.nextLine();
	                       System.out.println("Enter The Duration of the song");
	                       String duration=input.nextLine();
	                       songg s=new songg(songname,artist,duration);
	                       songs.add(s);
	                       System.out.println(songname+" song is added to playlist "+playlistname+"!!!\n");
	                       break;
	                case 2:
	                     if(songs.size()==0){
	                     System.out.println("No songs present in the Playlist: "+playlistname);
	                     break;
	                     }
	                     else{
	                         System.out.println("Here is the List of songs");
	                         for(songg i:songs){  //enhanced for loop.
	                             i.showSong();
	                         }
	                         System.out.println("Enter The index of the song to remove,first song is at index 1");
	                         int index=input.nextInt();
	                      
	                         if(index<=0|| index>songs.size())
	                         {
	                             System.out.println("No Song in that index");
	                           
	                         }
	                         else{
	                         songs.remove(index-1);//As we don't want to confuse the user by the fact that actual index starts from zero.
	                         System.out.println("Song Removed!!");
	                         
	                         }
	                         break;
	                     }
	                       
	                case 3:
	                      if(songs.size()==0){
	                       System.out.println("No songs in the playlist");
	                       break;
	                          }
	                     else{
	                        System.out.println("Here is the List of songs");
	                         for(songg i:songs){//enhanced for loop
	                             i.showSong();
	                         }
	                        break;
	                          }
	                case 4: 
	                       if(songs.size()==0){
	                       System.out.println("No songs in the playlist");
	                       break;
	                          }
	                      else{
	                        System.out.println("Here is the List of songs");
	                         for(songg i:songs){ //enhanced for loop 
	                             i.showSong();
	                         }
	                         System.out.println("Current Song-----");
	                         songs.getFirst().showSong();
	                         ListIterator<songg> j=songs.listIterator();//This is iterator and helps us to iterate to a linked list.
	                        j.next();//as our first song is currently playing.
	                        boolean forward=true;//helps to keep a track as user is going forward the linked list or backwards
	                        boolean finished=false; //To check wheather the user reached end of the linked list or not.
	                      
	                    
	                        boolean second=true;
	                        while(second){
	                            System.out.println("\n Enter 1)To play the next song\n"
	                                                +"Enter 2)To play the previous song\n"
	                                                +"Enter 3)To play the same song again\n"
	                                                +"Enter 4)To stop the playlist");
	                            
	                             int choice2=input.nextInt();
	                       switch(choice2){
	                           case 1:
	                              
	                               if(!forward)
	                                {
	                                  if(j.hasNext())
	                                  {
	                                      j.next();
	                                  }
	                                  forward=true;
	                           
	                                }
	                               if(finished==true){
	                                   j.previous();
	                                   finished=false;
	                               }
	                       
	                       
	                                  
	                                  
	                                   
	                                    if(j.hasNext())
	                                    {
	                                    
	                                    System.out.println("Song Playing----->");
	                                    j.next().showSong();
	                      
	                                    }
	                                    else{
	                                    System.out.println("Playlist finished.....");
	                                    finished=true;
	                            
	                                    }
	                                   
	                                   
	                                
	                                    break;
	                           case 2:
	                                  
	                               
	                          if(forward)
	                         {
	                             if(j.hasPrevious())
	                             {
	                                 j.previous();
	                             }
	                      
	                             forward=false;
	                             
	                            
	                         }
	                          if(finished==true){
	                              j.next();
	                              finished=false;
	                          }
	                
	                  
	                        
	                        
	                        if(j.hasPrevious())
	                        {
	                        System.out.println("Song Playing------ ");
	                        j.previous().showSong();
	                      
	                        }
	                        else{
	                            System.out.println("Playlist finished.....");
	                            finished=true;
	                            
	                        }
	                    
	                        break;
	                           case 3:
	                               if(forward)
	                                  {System.out.println("Current Song again\n\n");
	                                    j.previous().showSong();
	                                    forward=false;
	                                   }
	                               if(!forward)
	                                {   System.out.println("Current Song again\n\n");
	                                    j.next().showSong();
	                                    forward=true;
	                                }
	                            
	                            break;
	                           case 4:second=false;
	                                 
	                                   break;
	                           default:second=false;
	                                 
	                                   break;
	                           }
	                       }
	                          }
	                       break;
	                case 5:first=false;
	                       break;
	                default:first=false;
	                        break;
	                        
	                        
	            }
	        }
	        
	        
	        }
	        }


