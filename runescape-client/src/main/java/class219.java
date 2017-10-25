import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class219 implements class218 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2779;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2787;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2778;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2780;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2781;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2782;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2785;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2784;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public static final class219 field2783;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   static final class219 field2786;
   @ObfuscatedName("l")
   static int[] field2789;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1576396191
   )
   public final int field2788;

   static {
      field2779 = new class219("", 10);
      field2778 = new class219("", 11);
      field2780 = new class219("", 12);
      field2781 = new class219("", 13);
      field2782 = new class219("", 14);
      field2785 = new class219("", 15, new ScriptVarType[]{ScriptVarType.field77, ScriptVarType.field77}, (ScriptVarType[])null);
      field2784 = new class219("", 16, new ScriptVarType[]{ScriptVarType.field77, ScriptVarType.field77}, (ScriptVarType[])null);
      field2783 = new class219("", 17, new ScriptVarType[]{ScriptVarType.field77, ScriptVarType.field77}, (ScriptVarType[])null);
      field2786 = new class219("", 73, true, true);
      field2787 = new class219("", 76, true, false);
   }

   class219(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lp;Z[Lp;)V"
   )
   class219(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2788 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lp;[Lp;)V"
   )
   class219(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field2788;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;I)[Ljo;",
      garbageValue = "-661504365"
   )
   public static IndexedSprite[] method4135(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return Projectile.method1782(var0, var3, var4);
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-39856878"
   )
   static final void method4134(int var0) {
      int[] var1 = ScriptVarType.field85.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class3.region.method2751(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class3.region.method2751(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      ScriptVarType.field85.method5165();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               class33.method349(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class33.method349(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1164 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class3.region.method2746(class46.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = CollisionData.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.field1145[Client.field1164] = Area.field3285[var8].method4368(false);
                  Client.field1143[Client.field1164] = var5;
                  Client.field1179[Client.field1164] = var6;
                  ++Client.field1164;
               }
            }
         }
      }

      GameEngine.field733.setRaster();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "710"
   )
   public static int method4137(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
