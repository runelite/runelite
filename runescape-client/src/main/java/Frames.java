import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lex;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lii;Lii;IZ)V"
   )
   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.getChild(0, var11);
            } else {
               var13 = var2.getChild(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-769168061"
   )
   public boolean method2919(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lky;I)Ljava/lang/String;",
      garbageValue = "1973992208"
   )
   public static String method2925(CharSequence var0, class290 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && Preferences.method1599(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && Preferences.method1599(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3855) {
               case 1:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var10 = new StringBuilder(var4);

               for(int var11 = var2; var11 < var3; ++var11) {
                  char var7 = var0.charAt(var11);
                  if(Script.method1859(var7)) {
                     char var8;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var8 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var8 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var8 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var8 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var8 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var8 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var8 = 110;
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var8 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var8 = 117;
                        break;
                     case 'ß':
                        var8 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var8 = 121;
                        break;
                     default:
                        var8 = Character.toLowerCase(var7);
                     }

                     if(var8 != 0) {
                        var10.append(var8);
                     }
                  }
               }

               if(var10.length() == 0) {
                  return null;
               }

               return var10.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   static void method2920() {
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = 1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.packetLength = 0;
      Client.field990 = 0;
      Client.field1059 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1079 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      Player.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1264 = false;
         }
      }

      ItemContainer.itemContainers = new HashTable(32);
      WorldMapType2.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1110[var0] = true;
      }

      class17.method144();
   }
}
