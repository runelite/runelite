import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -478206321
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("d")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("z")
   @Export("lock")
   Object lock;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1459665061
   )
   @Export("index")
   int index;
   @ObfuscatedName("r")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("e")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; PacketBuffer.method3907(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Laf;",
      garbageValue = "-878285511"
   )
   static class33 method1100(int var0, int var1) {
      class213 var2 = class35.field484;
      long var3 = (long)(0 | var0 << 8 | var1);
      return (class33)var2.method4044(var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljk;IIIZI)V",
      garbageValue = "-931825979"
   )
   public static void method1095(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class229.field2694 = 1;
      class229.field2687 = var0;
      class229.field2691 = var1;
      AttackOption.field1331 = var2;
      class229.field2692 = var3;
      class37.field506 = var4;
      class284.field3699 = 10000;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1652967387"
   )
   static void method1099(Buffer var0) {
      if(Client.field889 != null) {
         var0.putBytes(Client.field889, 0, Client.field889.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            class167.randomDat.seek(0L);
            class167.randomDat.read(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if(var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.putBytes(var2, 0, var2.length);
      }
   }
}
