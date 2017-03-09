import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public final class class33 extends Renderable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1623090451
   )
   int field764 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1680202415
   )
   int field765;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1711416741
   )
   int field766;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1514987745
   )
   int field767;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -365758939
   )
   int field768;
   @ObfuscatedName("u")
   Sequence field769;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1816704817
   )
   int field770;
   @ObfuscatedName("bd")
   static ModIcon[] field771;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2099081885
   )
   int field772 = 0;
   @ObfuscatedName("y")
   boolean field773 = false;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1572104549
   )
   int field776;
   @ObfuscatedName("rl")
   protected static String field777;
   @ObfuscatedName("bb")
   static class184 field778;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1523496158"
   )
   final void method754(int var1) {
      if(!this.field773) {
         this.field772 += var1;

         while(this.field772 > this.field769.frameLenghts[this.field764]) {
            this.field772 -= this.field769.frameLenghts[this.field764];
            ++this.field764;
            if(this.field764 >= this.field769.frameIDs.length) {
               this.field773 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-10054"
   )
   protected final Model getModel() {
      Spotanim var1 = Widget.method3245(this.field770);
      Model var2;
      if(!this.field773) {
         var2 = var1.method3474(this.field764);
      } else {
         var2 = var1.method3474(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "-665008903"
   )
   public static final class57 method756(class103 var0, Component var1, int var2, int var3) {
      if(class148.field2033 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1053 = new int[(class57.field1058?2:1) * 256];
            var4.field1060 = var3;
            var4.vmethod1196(var1);
            var4.field1059 = 1024 + (var3 & -1024);
            if(var4.field1059 > 16384) {
               var4.field1059 = 16384;
            }

            var4.vmethod1198(var4.field1059);
            if(class57.field1051 > 0 && null == class57.field1052) {
               class57.field1052 = new class63();
               class57.field1052.field1100 = var0;
               var0.method2023(class57.field1052, class57.field1051);
            }

            if(null != class57.field1052) {
               if(class57.field1052.field1096[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class57.field1052.field1096[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field770 = var1;
      this.field766 = var2;
      this.field767 = var3;
      this.field768 = var4;
      this.field776 = var5;
      this.field765 = var6 + var7;
      int var8 = Widget.method3245(this.field770).field2792;
      if(var8 != -1) {
         this.field773 = false;
         this.field769 = class168.getAnimation(var8);
      } else {
         this.field773 = true;
      }

   }

   @ObfuscatedName("j")
   static final void method763(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }
}
