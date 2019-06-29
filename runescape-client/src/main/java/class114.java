import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
public class class114 {
   @ObfuscatedName("m")
   int field1453;
   @ObfuscatedName("f")
   int field1454;
   @ObfuscatedName("q")
   int[] field1452;
   @ObfuscatedName("w")
   int[] field1455;

   class114() {
      MusicSample.method2352(16);
      this.field1453 = MusicSample.method2338() != 0?MusicSample.method2352(4) + 1:1;
      if(MusicSample.method2338() != 0) {
         MusicSample.method2352(8);
      }

      MusicSample.method2352(2);
      if(this.field1453 > 1) {
         this.field1454 = MusicSample.method2352(4);
      }

      this.field1452 = new int[this.field1453];
      this.field1455 = new int[this.field1453];

      for(int var1 = 0; var1 < this.field1453; ++var1) {
         MusicSample.method2352(8);
         this.field1452[var1] = MusicSample.method2352(8);
         this.field1455[var1] = MusicSample.method2352(8);
      }

   }
}
