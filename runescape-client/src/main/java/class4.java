import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class4 implements class178 {
   @ObfuscatedName("x")
   public static int[] field33;
   @ObfuscatedName("e")
   static final class4 field34;
   @ObfuscatedName("i")
   static final class4 field35;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -777805479
   )
   final int field36;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 367439821
   )
   final int field37;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 430392551
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 868283481
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("cc")
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("c")
   static final class4 field41;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "25310"
   )
   public static int method4(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field36;
   }

   static {
      field35 = new class4(0, 0, Integer.class, new class2());
      field41 = new class4(2, 1, Long.class, new class3());
      field34 = new class4(1, 2, String.class, new class5());
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "24760"
   )
   static int method7(int var0, Script var1, boolean var2) {
      Widget var3 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
      if(var0 == 2600) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2705;
         return 1;
      } else if(var0 == 2606) {
         class83.intStack[++class83.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class83.intStack[++class83.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class83.intStack[++class83.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class83.intStack[++class83.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2683;
         return 1;
      } else if(var0 == 2611) {
         class83.intStack[++class83.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2708;
         return 1;
      } else if(var0 == 2613) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2681.vmethod5009();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1307271244"
   )
   static void method8(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(XClanMember.method1140(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method8(var0, var7 - 1, var2, var3, var4, var5);
         method8(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("i")
   public static final void method9(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            ChatLineBuffer.method1868(var0 - 1L);
            ChatLineBuffer.method1868(1L);
         } else {
            ChatLineBuffer.method1868(var0);
         }

      }
   }

   class4(int var1, int var2, Class var3, class0 var4) {
      this.field37 = var1;
      this.field36 = var2;
   }
}
