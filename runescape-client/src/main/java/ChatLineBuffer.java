import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("pn")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lbv;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 783141031
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbv;",
      garbageValue = "1834772338"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lbv;",
      garbageValue = "-723492850"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2039073684"
   )
   @Export("size")
   int size() {
      return this.length;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "740482870"
   )
   static final void method2077(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class62.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var1][var3 + var2] = class62.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var3 + var1][var2] = class62.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class62.tileHeights[var0][var1 - 1][var2] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class62.tileHeights[var0][var1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class62.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }
}
