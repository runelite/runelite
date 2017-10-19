import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("gr")
public class class182 {
   @ObfuscatedName("w")
   public static final String[][] field2436;
   @ObfuscatedName("s")
   public static final String[] field2439;
   @ObfuscatedName("q")
   public static Calendar field2438;

   static {
      field2436 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2439 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2438 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "39"
   )
   public static void method3533() {
      CombatInfo2.field3360.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lik;",
      garbageValue = "1864201547"
   )
   public static class251 method3532(int var0) {
      class251 var1 = (class251)class251.field3387.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3385.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4508(new Buffer(var2));
         }

         var1.method4507();
         class251.field3387.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljo;I)V",
      garbageValue = "1383513119"
   )
   static final void method3534(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < Frames.field2125.length; ++var2) {
         Frames.field2125[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         Frames.field2125[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class164.field2312[var5] = (Frames.field2125[var5 - 128] + Frames.field2125[var5 + 1] + Frames.field2125[var5 + 128] + Frames.field2125[var5 - 1]) / 4;
            }
         }

         int[] var8 = Frames.field2125;
         Frames.field2125 = class164.field2312;
         class164.field2312 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  Frames.field2125[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2000004824"
   )
   static final void method3531(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field1036 == 1) && Client.friendCount < 400) {
            String var1 = WidgetNode.method1087(var0, Permission.field3169);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = WidgetNode.method1087(var3.name, Permission.field3169);
                  if(var4 != null && var4.equals(var1)) {
                     class174.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = WidgetNode.method1087(var3.previousName, Permission.field3169);
                     if(var5 != null && var5.equals(var1)) {
                        class174.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = WidgetNode.method1087(var6.name, Permission.field3169);
                  if(var4 != null && var4.equals(var1)) {
                     class174.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = WidgetNode.method1087(var6.previousName, Permission.field3169);
                     if(var5 != null && var5.equals(var1)) {
                        class174.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(WidgetNode.method1087(class66.localPlayer.name, Permission.field3169).equals(var1)) {
                  class174.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADD_FRIEND);
                  Client.secretPacketBuffer1.putByte(class86.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            class174.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
