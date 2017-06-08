import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("bd")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("n")
   Component field654;
   @ObfuscatedName("cr")
   static IndexData field655;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "1532548489"
   )
   public static void method762(IndexDataBase var0) {
      class244.field3324 = var0;
   }

   public final void update(Graphics var1) {
      this.field654.update(var1);
   }

   RSCanvas(Component var1) {
      this.field654 = var1;
   }

   public final void paint(Graphics var1) {
      this.field654.paint(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "17077"
   )
   static int method771(int var0, Script var1, boolean var2) {
      Widget var3 = class177.method3390(class83.intStack[--class165.intStackSize]);
      if(var0 == 2800) {
         class83.intStack[++class165.intStackSize - 1] = GameEngine.method844(class251.method4472(var3));
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class83.intStack[--class165.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1314183554"
   )
   public static Object method772(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class176.field2419) {
            try {
               class171 var2 = new class171();
               var2.vmethod3374(var0);
               return var2;
            } catch (Throwable var3) {
               class176.field2419 = true;
            }
         }

         return var0;
      }
   }
}
