import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1552726169
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 432430245
   )
   @Export("height")
   int height;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1580449221
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 141445187
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2040205609
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1165554559
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1278992915
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -916577623
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 458224183
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1214179713
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2106641225
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -115111159
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2083386589
   )
   @Export("cycle")
   int cycle;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1657890590"
   )
   static int method2890(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class83.intStack[--class46.intStackSize];
         class83.intStack[++class46.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class83.intStack[--class46.intStackSize];
         class83.intStack[++class46.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class46.intStackSize -= 5;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         int var11 = class83.intStack[class46.intStackSize + 2];
         int var6 = class83.intStack[class46.intStackSize + 3];
         int var12 = class83.intStack[class46.intStackSize + 4];
         class83.intStack[++class46.intStackSize - 1] = var3 + (var4 - var3) * (var12 - var11) / (var6 - var11);
         return 1;
      } else if(var0 == 4007) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class46.intStackSize - 1] = 0;
         } else {
            class83.intStack[++class46.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class46.intStackSize - 1] = 0;
         } else if(var4 == 0) {
            class83.intStack[++class46.intStackSize - 1] = Integer.MAX_VALUE;
         } else {
            class83.intStack[++class46.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
         }

         return 1;
      } else if(var0 == 4014) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         class83.intStack[++class46.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class46.intStackSize -= 3;
         long var5 = (long)class83.intStack[class46.intStackSize];
         long var7 = (long)class83.intStack[class46.intStackSize + 1];
         long var9 = (long)class83.intStack[class46.intStackSize + 2];
         class83.intStack[++class46.intStackSize - 1] = (int)(var9 * var5 / var7);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1118630535"
   )
   static final void method2891(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field1049 == 1) && Client.ignoreCount < 400) {
            String var2 = Player.method1179(var0, Client.field928);
            if(var2 != null) {
               int var3;
               String var4;
               String var5;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var6 = Client.ignores[var3];
                  var4 = Player.method1179(var6.name, Client.field928);
                  if(var4 != null && var4.equals(var2)) {
                     class152.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = Player.method1179(var6.previousName, Client.field928);
                     if(var5 != null && var5.equals(var2)) {
                        class152.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var4 = Player.method1179(var7.name, Client.field928);
                  if(var4 != null && var4.equals(var2)) {
                     class152.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var5 = Player.method1179(var7.previousName, Client.field928);
                     if(var5 != null && var5.equals(var2)) {
                        class152.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(Player.method1179(XItemContainer.localPlayer.name, Client.field928).equals(var2)) {
                  class152.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(33);
                  Client.secretPacketBuffer1.putByte(class261.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            class152.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "-848726571"
   )
   static int method2892(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1569()?(var1.method1569()?0:1):(var1.method1569()?-1:0)):(var2 == 5?(var0.method1567()?(var1.method1567()?0:1):(var1.method1567()?-1:0)):(var2 == 6?(var0.method1565()?(var1.method1565()?0:1):(var1.method1565()?-1:0)):(var2 == 7?(var0.method1566()?(var1.method1566()?0:1):(var1.method1566()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "805916230"
   )
   static void method2893() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         class13.method64("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var0 = class239.method4263();
         int var2;
         if(0L == var0) {
            var2 = 5;
         } else {
            var2 = class134.method2576(var0, class92.username);
         }

         switch(var2) {
         case 2:
            class13.method64("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            class13.method64("", "Error connecting to server.", "");
            break;
         case 4:
            class13.method64("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class13.method64("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class13.method64("", "Error connecting to server.", "");
            break;
         case 7:
            class13.method64("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }
      }

   }

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }
}
