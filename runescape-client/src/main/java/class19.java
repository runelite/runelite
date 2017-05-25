import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class19 implements Comparator {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -742586857
   )
   public static int field320;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-167014731"
   )
   int method138(class14 var1, class14 var2) {
      return var1.field289 < var2.field289?-1:(var1.field289 == var2.field289?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method138((class14)var1, (class14)var2);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1891012705"
   )
   static void method143() {
      if(Client.field1045) {
         Widget var0 = class66.method1099(CollisionData.field2278, Client.field1046);
         if(var0 != null && var0.field2736 != null) {
            class69 var1 = new class69();
            var1.field816 = var0;
            var1.field826 = var0.field2736;
            GroundObject.method2522(var1);
         }

         Client.field1045 = false;
         class219.method4130(var0);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)LScript;",
      garbageValue = "1404612003"
   )
   static Script method144(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1880(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            class186 var9 = new class186(ChatLineBuffer.method1895(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.method3575(new class198(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.method3206();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("i")
   public static final void method145(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            class38.method513(1L);
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
