import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class177 {
   @ObfuscatedName("x")
   public static final short[] field2946 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
   @ObfuscatedName("r")
   public static final short[][] field2947 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127}};
   @ObfuscatedName("j")
   public static final short[] field2948 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
   @ObfuscatedName("z")
   public static final short[][] field2950 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-677471748"
   )
   static final void method3470(int var0, int var1, int var2, int var3) {
      if(Client.field465 == 1) {
         XClanMember.field631[Client.field391 / 100].method1740(Client.field334 - 8, Client.field390 - 8);
      }

      if(Client.field465 == 2) {
         XClanMember.field631[4 + Client.field391 / 100].method1740(Client.field334 - 8, Client.field390 - 8);
      }

      Sequence.method902();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-2048786102"
   )
   static void method3471(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = class35.worldList[var6];
         class35.worldList[var6] = class35.worldList[var1];
         class35.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class48.method991(class35.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = class35.worldList[var9];
               class35.worldList[var9] = class35.worldList[var7];
               class35.worldList[var7++] = var10;
            }
         }

         class35.worldList[var1] = class35.worldList[var7];
         class35.worldList[var7] = var8;
         method3471(var0, var7 - 1, var2, var3, var4, var5);
         method3471(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1475971176"
   )
   public static void method3472() {
      if(class139.field2141.toLowerCase().indexOf("microsoft") != -1) {
         class140.field2175[186] = 57;
         class140.field2175[187] = 27;
         class140.field2175[188] = 71;
         class140.field2175[189] = 26;
         class140.field2175[190] = 72;
         class140.field2175[191] = 73;
         class140.field2175[192] = 58;
         class140.field2175[219] = 42;
         class140.field2175[220] = 74;
         class140.field2175[221] = 43;
         class140.field2175[222] = 59;
         class140.field2175[223] = 28;
      } else {
         class140.field2175[44] = 71;
         class140.field2175[45] = 26;
         class140.field2175[46] = 72;
         class140.field2175[47] = 73;
         class140.field2175[59] = 57;
         class140.field2175[61] = 27;
         class140.field2175[91] = 42;
         class140.field2175[92] = 74;
         class140.field2175[93] = 43;
         class140.field2175[192] = 28;
         class140.field2175[222] = 58;
         class140.field2175[520] = 59;
      }

   }
}
