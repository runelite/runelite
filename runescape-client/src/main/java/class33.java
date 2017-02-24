import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public final class class33 extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1181798041
   )
   int field761 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1525343669
   )
   int field762;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 322088235
   )
   int field763;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 40932701
   )
   int field764;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1064576323
   )
   int field765;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      longValue = -1799201454180219235L
   )
   static long field766;
   @ObfuscatedName("r")
   Sequence field767;
   @ObfuscatedName("o")
   boolean field768 = false;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 1254223677
   )
   static int field770;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1361804021
   )
   int field771;
   @ObfuscatedName("cn")
   public static char field772;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1443751795
   )
   int field773;
   @ObfuscatedName("pu")
   public static class103 field775;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 329078307
   )
   int field776 = 0;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1702232553"
   )
   final void method778(int var1) {
      if(!this.field768) {
         this.field776 += var1;

         while(this.field776 > this.field767.frameLenghts[this.field761]) {
            this.field776 -= this.field767.frameLenghts[this.field761];
            ++this.field761;
            if(this.field761 >= this.field767.frameIDs.length) {
               this.field768 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "-670865168"
   )
   public static CombatInfo2 method781(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2834.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2837.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(null != var2) {
            var1.method3528(new Buffer(var2));
         }

         CombatInfo2.field2834.put(var1, (long)var0);
         return var1;
      }
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field763 = var1;
      this.field773 = var2;
      this.field764 = var3;
      this.field765 = var4;
      this.field771 = var5;
      this.field762 = var7 + var6;
      int var8 = Renderable.method1953(this.field763).field2807;
      if(var8 != -1) {
         this.field768 = false;
         this.field767 = class195.getAnimation(var8);
      } else {
         this.field768 = true;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "-2097142145"
   )
   public static final class57 method784(class103 var0, Component var1, int var2, int var3) {
      if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1066 = new int[256 * (class57.field1070?2:1)];
            var4.field1069 = var3;
            var4.vmethod1175(var1);
            var4.field1068 = 1024 + (var3 & -1024);
            if(var4.field1068 > 16384) {
               var4.field1068 = 16384;
            }

            var4.vmethod1178(var4.field1068);
            if(class57.field1062 > 0 && class57.field1064 == null) {
               class57.field1064 = new class63();
               class57.field1064.field1104 = var0;
               var0.method2025(class57.field1064, class57.field1062);
            }

            if(class57.field1064 != null) {
               if(null != class57.field1064.field1107[var2]) {
                  throw new IllegalArgumentException();
               }

               class57.field1064.field1107[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   static final void method785() {
      int[] var0 = class45.field931;

      int var1;
      for(var1 = 0; var1 < class45.field921; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field638 > 0) {
            --var2.field638;
            if(var2.field638 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field340; ++var1) {
         int var4 = Client.field345[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(null != var3 && var3.field638 > 0) {
            --var3.field638;
            if(var3.field638 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "286397846"
   )
   protected final Model getModel() {
      Spotanim var1 = Renderable.method1953(this.field763);
      Model var2;
      if(!this.field768) {
         var2 = var1.method3472(this.field761);
      } else {
         var2 = var1.method3472(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-780112337"
   )
   public static void method787(boolean var0) {
      if(var0 != ItemComposition.isMembersWorld) {
         class22.method223();
         ItemComposition.isMembersWorld = var0;
      }

   }
}
