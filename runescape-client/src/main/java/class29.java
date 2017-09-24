import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public final class class29 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -510525503
   )
   static int field433;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   final class41 this$0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1375423633
   )
   int field430;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1417589321
   )
   int field431;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -926289463
   )
   int field429;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2145940451
   )
   int field427;

   @ObfuscatedSignature(
      signature = "(Lao;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1819998997"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class97.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class97.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class97.field1532.put(var5, (long)var5.id);
      class97.field1536.method3743(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1956061000"
   )
   public static File method273(String var0) {
      if(!class158.field2260) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class158.field2261.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class158.field2265, var0);
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
                  class158.field2261.put(var0, var2);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1553626600"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = ScriptVarType.getSmoothNoise2D(var3, var5);
      int var8 = ScriptVarType.getSmoothNoise2D(var3 + 1, var5);
      int var9 = ScriptVarType.getSmoothNoise2D(var3, var5 + 1);
      int var10 = ScriptVarType.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = (var14 * var10 >> 16) + ((65536 - var14) * var9 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }
}
