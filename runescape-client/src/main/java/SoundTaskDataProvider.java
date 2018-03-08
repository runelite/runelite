import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements class101 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("NetCache_socket")
   public static class169 NetCache_socket;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field618;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -186219081
   )
   static int field619;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ldr;",
      garbageValue = "-1129650376"
   )
   public AbstractSoundSystem vmethod2122() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1242601985"
   )
   static int method831(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "-15"
   )
   static boolean method835(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class57.field636.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class53.method844(class57.field635, var2, new Object[]{(new URL(class57.field635.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class57.field635.getAppletContext().showDocument(new URL(class57.field635.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class53.method840(class57.field635, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class57.field635.getAppletContext().showDocument(new URL(class57.field635.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "127"
   )
   static int method837(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.getWidget(class81.intStack[--class5.intStackSize]);
      } else {
         var3 = var2?class233.field2755:class81.field1260;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class81.intStack[--class5.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class81.scriptStringStack[--class316.scriptStringStackSize]);
            return 1;
         } else {
            --class316.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class5.intStackSize -= 2;
         var4 = class81.intStack[class5.intStackSize];
         int var5 = class81.intStack[class5.intStackSize + 1];
         var3.dragParent = CollisionData.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2895 = class81.intStack[--class5.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2817 = class81.intStack[--class5.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2894 = class81.intStack[--class5.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class81.scriptStringStack[--class316.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class81.scriptStringStack[--class316.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-68"
   )
   static int method838() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "337584771"
   )
   static final void method833() {
      Client.myPlayerIndex = 0;
      int var0 = (WorldMapData.localPlayer.x >> 7) + class38.baseX;
      int var1 = (WorldMapData.localPlayer.y >> 7) + PlayerComposition.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.myPlayerIndex = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.myPlayerIndex = 1;
      }

      if(Client.myPlayerIndex == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.myPlayerIndex = 0;
      }

   }
}
