import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
public class class294 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 7474998500400220401L
   )
   long field3815;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 5068573144265570637L
   )
   long field3816;
   @ObfuscatedName("n")
   public boolean field3813;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 8238140593253321335L
   )
   long field3811;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -326811917313768935L
   )
   long field3820;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 7117941610937261925L
   )
   long field3814;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1726447567
   )
   int field3817;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1377654791
   )
   int field3818;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -978811947
   )
   int field3819;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -45529125
   )
   int field3812;

   public class294() {
      this.field3815 = -1L;
      this.field3816 = -1L;
      this.field3813 = false;
      this.field3811 = 0L;
      this.field3820 = 0L;
      this.field3814 = 0L;
      this.field3817 = 0;
      this.field3818 = 0;
      this.field3819 = 0;
      this.field3812 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1396190213"
   )
   public void method5317() {
      this.field3815 = PendingSpawn.currentTimeMs();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   public void method5343() {
      if(this.field3815 != -1L) {
         this.field3820 = PendingSpawn.currentTimeMs() - this.field3815;
         this.field3815 = -1L;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-65"
   )
   public void method5319(int var1) {
      this.field3816 = PendingSpawn.currentTimeMs();
      this.field3817 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1636814638"
   )
   public void method5320() {
      if(this.field3816 != -1L) {
         this.field3811 = PendingSpawn.currentTimeMs() - this.field3816;
         this.field3816 = -1L;
      }

      ++this.field3819;
      this.field3813 = true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1245748376"
   )
   public void method5322() {
      this.field3813 = false;
      this.field3818 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-87"
   )
   public void method5342() {
      this.method5320();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-85"
   )
   public void method5323(Buffer var1) {
      Signlink.method3299(var1, this.field3820);
      Signlink.method3299(var1, this.field3811);
      Signlink.method3299(var1, this.field3814);
      var1.putShort(this.field3817);
      var1.putShort(this.field3818);
      var1.putShort(this.field3819);
      var1.putShort(this.field3812);
   }
}
