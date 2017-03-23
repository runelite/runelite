import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class1 {
   @ObfuscatedName("l")
   static SpritePixels field7;
   @ObfuscatedName("i")
   public static Comparator field8 = new class7();
   @ObfuscatedName("s")
   static int[] field9;
   @ObfuscatedName("h")
   public static Comparator field10;
   @ObfuscatedName("r")
   public static Comparator field11;
   @ObfuscatedName("f")
   public final List field13;
   @ObfuscatedName("d")
   static class181 field14;
   @ObfuscatedName("u")
   public static Comparator field16;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "19"
   )
   static int method4(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class154.field2123:class32.field746;
      if(var0 == 1800) {
         int[] var4 = class32.field743;
         int var5 = ++class30.field713 - 1;
         int var7 = FloorUnderlayDefinition.method3533(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            } else {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class32.field743[--class30.field713];
         --var8;
         if(null != var3.actions && var8 < var3.actions.length && var3.actions[var8] != null) {
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "79976678"
   )
   public void method5(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field13, var1);
      } else {
         Collections.sort(this.field13, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field13 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field13.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "-2034248195"
   )
   static String method7(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = NPC.method748(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(null != class36.field795) {
               var7 = class172.method3307(class36.field795.field1688);
               if(null != class36.field795.field1690) {
                  var7 = (String)class36.field795.field1690;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   static {
      new class0();
      field16 = new class5();
      field10 = new class6();
      field11 = new class3();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "20"
   )
   static void method8(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }
}
