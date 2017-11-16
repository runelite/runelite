import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class44 extends WorldMapData {
   @ObfuscatedName("v")
   static int[] field540;
   @ObfuscatedName("aw")
   protected static String field537;
   @ObfuscatedName("bq")
   static String field538;
   @ObfuscatedName("a")
   HashSet field539;
   @ObfuscatedName("q")
   HashSet field535;
   @ObfuscatedName("j")
   List field534;

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(Lfs;Lfs;Lfs;IZI)V",
      garbageValue = "-1641762415"
   )
   void method591(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field539 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method155(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field539.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field535 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method602(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field535.add(var9);
      }

      this.method598(var2, var5);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(Lfs;ZI)V",
      garbageValue = "2050394066"
   )
   void method598(Buffer var1, boolean var2) {
      this.field534 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3201();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field534.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1423541017"
   )
   public static void method590() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field596 = KeyFocusListener.field598;
         KeyFocusListener.field601 = 0;
         int var1;
         if(KeyFocusListener.field591 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field578[var1] = false;
            }

            KeyFocusListener.field591 = KeyFocusListener.field590;
         } else {
            while(KeyFocusListener.field590 != KeyFocusListener.field591) {
               var1 = KeyFocusListener.field589[KeyFocusListener.field590];
               KeyFocusListener.field590 = KeyFocusListener.field590 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field578[~var1] = false;
               } else {
                  if(!KeyFocusListener.field578[var1] && KeyFocusListener.field601 < KeyFocusListener.field594.length - 1) {
                     KeyFocusListener.field594[++KeyFocusListener.field601 - 1] = var1;
                  }

                  KeyFocusListener.field578[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field601 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field598 = KeyFocusListener.field597;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;Ljava/lang/String;Ljava/lang/String;I)Ljn;",
      garbageValue = "2033006902"
   )
   public static Font method600(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return class287.method4954(var0, var1, var4, var5);
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Lhx;IIB)V",
      garbageValue = "0"
   )
   static final void method595(Widget var0, int var1, int var2) {
      if(Client.field1020 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var4 = class89.method1680(var0);
            if(var4 == null) {
               var4 = var0.dragParent;
            }

            if(var4 != null) {
               Client.field1020 = var0;
               var4 = class89.method1680(var0);
               if(var4 == null) {
                  var4 = var0.dragParent;
               }

               Client.field1021 = var4;
               Client.field1022 = var1;
               Client.field1121 = var2;
               class61.field711 = 0;
               Client.field993 = false;
               int var6 = Client.menuOptionCount - 1;
               if(var6 != -1) {
                  CacheFile.method2363(var6);
               }

               return;
            }
         }

      }
   }
}
