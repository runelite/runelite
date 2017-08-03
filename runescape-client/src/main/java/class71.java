import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class71 implements Runnable {
   @ObfuscatedName("d")
   boolean field836;
   @ObfuscatedName("q")
   Object field839;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -926838557
   )
   int field837;
   @ObfuscatedName("y")
   int[] field838;
   @ObfuscatedName("e")
   int[] field841;

   class71() {
      this.field836 = true;
      this.field839 = new Object();
      this.field837 = 0;
      this.field838 = new int[500];
      this.field841 = new int[500];
   }

   public void run() {
      for(; this.field836; GroundObject.method2492(50L)) {
         Object var1 = this.field839;
         synchronized(this.field839) {
            if(this.field837 < 500) {
               this.field838[this.field837] = MouseInput.field696;
               this.field841[this.field837] = MouseInput.field705;
               ++this.field837;
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2077305241"
   )
   public static void method1129() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "15"
   )
   static String method1131(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(WorldMapType3.sessionToken != null) {
         var3 = "/p=" + WorldMapType3.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class5.field34 + var3 + "/";
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "85342318"
   )
   static void method1128(File var0) {
      class157.field2233 = var0;
      if(!class157.field2233.exists()) {
         throw new RuntimeException("");
      } else {
         class157.field2232 = true;
      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-55"
   )
   static void method1130(int var0, int var1, int var2) {
      if(Client.field1125 != 0 && var1 != 0 && Client.field1124 < 50) {
         Client.field1089[Client.field1124] = var0;
         Client.field917[Client.field1124] = var1;
         Client.field1105[Client.field1124] = var2;
         Client.audioEffects[Client.field1124] = null;
         Client.field1128[Client.field1124] = 0;
         ++Client.field1124;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;I)V",
      garbageValue = "550072768"
   )
   public static void method1134(IndexDataBase var0) {
      class251.field3365 = var0;
   }
}
