import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("au")
   static ModIcon[] field204;
   @ObfuscatedName("x")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("y")
   public static String field207;
   @ObfuscatedName("z")
   static class228 field209;
   @ObfuscatedName("i")
   public static class182 field210;
   @ObfuscatedName("u")
   @Export("name")
   String name;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1459719433"
   )
   static File method188(String var0) {
      if(!class107.field1717) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1718.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class107.field1715, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1718.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "40"
   )
   static void method189() {
      Client.field326.offset = 0;
      Client.field409.offset = 0;
      Client.packetOpcode = -1;
      Client.field333 = 1;
      Client.field334 = -1;
      Client.field335 = -1;
      Client.field328 = 0;
      Client.field308 = 0;
      Client.field297 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field543 = 0;
      Client.flagX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class148.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(null != var1) {
            var1.interacting = -1;
            var1.field613 = false;
         }
      }

      class156.method3005();
      Friend.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field485[var0] = true;
      }

      Client.field326.method3029(112);
      Client.field326.method2760(class182.method3335());
      Client.field326.method2918(class0.field1);
      Client.field326.method2918(class65.field1099);
   }
}
