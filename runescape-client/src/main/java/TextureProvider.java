import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("TextureProvider")
public class TextureProvider implements class145 {
   @ObfuscatedName("m")
   Deque field1773;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1539092463
   )
   int field1774;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1331825107
   )
   int field1777;
   @ObfuscatedName("j")
   IndexDataBase field1778;
   @ObfuscatedName("p")
   class130[] field1779;
   @ObfuscatedName("w")
   double field1781;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1973203057
   )
   int field1783;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1744643585"
   )
   public boolean vmethod2774(int var1) {
      return this.field1777 == 64;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2280(double var1) {
      this.field1781 = var1;
      this.method2285();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-25"
   )
   public int vmethod2771(int var1) {
      return this.field1779[var1] != null?this.field1779[var1].field1875:0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1105926055"
   )
   public boolean vmethod2778(int var1) {
      return this.field1779[var1].field1876;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "653892919"
   )
   public void method2285() {
      for(int var1 = 0; var1 < this.field1779.length; ++var1) {
         if(this.field1779[var1] != null) {
            this.field1779[var1].method2379();
         }
      }

      this.field1773 = new Deque();
      this.field1783 = this.field1774;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method2286(int var1) {
      for(int var2 = 0; var2 < this.field1779.length; ++var2) {
         class130 var3 = this.field1779[var2];
         if(var3 != null && var3.field1881 != 0 && var3.field1884) {
            var3.method2385(var1);
            var3.field1884 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.field1773 = new Deque();
      this.field1783 = 0;
      this.field1781 = 1.0D;
      this.field1777 = 128;
      this.field1778 = var2;
      this.field1774 = var3;
      this.field1783 = this.field1774;
      this.field1781 = var4;
      this.field1777 = var6;
      int[] var7 = var1.method4005(0);
      int var8 = var7.length;
      this.field1779 = new class130[var1.method4075(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1779[var7[var9]] = new class130(var10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "606310637"
   )
   @Export("load")
   public int[] load(int var1) {
      class130 var2 = this.field1779[var1];
      if(var2 != null) {
         if(var2.field1883 != null) {
            this.field1773.method3501(var2);
            var2.field1884 = true;
            return var2.field1883;
         }

         boolean var3 = var2.method2382(this.field1781, this.field1777, this.field1778);
         if(var3) {
            if(this.field1783 == 0) {
               class130 var4 = (class130)this.field1773.method3513();
               var4.method2379();
            } else {
               --this.field1783;
            }

            this.field1773.method3501(var2);
            var2.field1884 = true;
            return var2.field1883;
         }
      }

      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "1685177464"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(CombatInfoListHolder.field1357, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var11 = new FileOnDisk(var3, "rw", 10000L);
            return var11;
         } catch (IOException var10) {
            ;
         }
      }

      String var4 = "";
      if(class140.field2123 == 33) {
         var4 = "_rc";
      } else if(class140.field2123 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class40.field555, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var9) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var8) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1905456887"
   )
   static final void method2306() {
      if(WidgetNode.rssocket != null) {
         WidgetNode.rssocket.method2879();
         WidgetNode.rssocket = null;
      }

      class7.method33();
      class17.region.method2589();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2912();
      }

      System.gc();
      class203.field2517 = 1;
      class203.field2518 = null;
      class203.field2519 = -1;
      class29.field438 = -1;
      class182.field2455 = 0;
      class88.field1384 = false;
      CollisionData.field2304 = 2;
      Client.field1142 = -1;
      Client.field1143 = false;
      class66.method1026();
      class23.setGameState(10);
   }
}
