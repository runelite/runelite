import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("v")
   @Export("value")
   String value;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1805092169
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 997708769
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @Export("sender")
   String sender;
   @ObfuscatedName("l")
   static byte[][] field843;
   @ObfuscatedName("nx")
   static class276 field844;
   @ObfuscatedName("et")
   static Font field845;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 211594541
   )
   @Export("id")
   int id;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "255"
   )
   void method1127(int var1, String var2, String var3, String var4) {
      this.id = class44.method643();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-2013189432"
   )
   static int method1128(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--class83.intStackSize];
         var4 = class261.method4792(var3);
      } else {
         var4 = var2?class83.field1311:Buffer.field2384;
      }

      if(var0 == 1000) {
         class83.intStackSize -= 4;
         var4.originalX = class83.intStack[class83.intStackSize];
         var4.originalY = class83.intStack[class83.intStackSize + 1];
         var4.field2647 = class83.intStack[class83.intStackSize + 2];
         var4.field2648 = class83.intStack[class83.intStackSize + 3];
         class219.method4130(var4);
         class24.field356.method1192(var4);
         if(var3 != -1 && var4.type == 0) {
            class24.method176(class90.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class83.intStackSize -= 4;
         var4.originalWidth = class83.intStack[class83.intStackSize];
         var4.field2638 = class83.intStack[class83.intStackSize + 1];
         var4.field2713 = class83.intStack[class83.intStackSize + 2];
         var4.field2654 = class83.intStack[class83.intStackSize + 3];
         class219.method4130(var4);
         class24.field356.method1192(var4);
         if(var3 != -1 && var4.type == 0) {
            class24.method176(class90.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--class83.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class219.method4130(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2775 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2776 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-128"
   )
   static void method1129(Buffer var0) {
      if(Client.field967 != null) {
         var0.putBytes(Client.field967, 0, Client.field967.length);
      } else {
         byte[] var1 = class134.method2618();
         var0.putBytes(var1, 0, var1.length);
      }
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = class44.method643();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "(I)Lclass288;",
      garbageValue = "-963316191"
   )
   static class288 method1130() {
      return class83.field1325;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-118819880"
   )
   static boolean method1131(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-2125104266"
   )
   static char method1133(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }
}
